package com.akushwah.examples.bootse1;

import java.awt.Color;
import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;

@JsonComponent
public class JsonExample {

	public static class Serializer extends JsonSerializer<User> {

		@Override
		public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
				throws IOException, JsonProcessingException {

			jsonGenerator.writeStartObject();
			jsonGenerator.writeStringField("name", user.getName());
			jsonGenerator.writeStringField("url", user.getUrl());
			jsonGenerator.writeStringField("favoriteColor", getColorAsWebColor(user.getFavoriteColor()));
			jsonGenerator.writeEndObject();
		}

		private static String getColorAsWebColor(Color color) {
//			return color.toString();
			return "Color:"+color.getRGB();
//			int r = (int) Math.round(color.getRed() * 255.0);
//			int g = (int) Math.round(color.getGreen() * 255.0);
//			int b = (int) Math.round(color.getBlue() * 255.0);
//			return String.format("#%02x%02x%02x", r, g, b);
		}
	}

	public static class Deserializer extends JsonDeserializer<User> {

		@Override
	    public User deserialize(JsonParser jsonParser, 
	      DeserializationContext deserializationContext) throws IOException, 
	      JsonProcessingException {
	  
	        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
	        TextNode favoriteColor
	          = (TextNode) treeNode.get("favoriteColor");
	        TextNode name
	          = (TextNode) treeNode.get("name");
	        TextNode url
	          = (TextNode) treeNode.get("url");
	        
	        User user = new User();
	        user.setName(name.asText());
	        user.setUrl(url.asText());
	        
	        user.setFavoriteColor(Color.decode(favoriteColor.asText()));
	        
	        
	        return user;
	    }
	}
}
