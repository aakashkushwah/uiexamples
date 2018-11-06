import { LikeComponent } from './like.component';
import {Point} from './point';

let point = new Point(34,45);
point.draw();

let component = new LikeComponent(10, true);
component.onClick();
console.log(`likesCount: ${component.likesCount}`);

