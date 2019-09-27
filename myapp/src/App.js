import React, { Component} from 'react';
import './App.css';
import Person from './person/Person';

// function App() {
//   return (
//     <div className="App">
//         <p>
//           Hi there I am a react app
//         </p>
//     </div>
//   );
// }

// const App = (props) => {

//   const [personStates, setPersonsState] = useState({
//     persons: [{name: 'Max', age: '24'}, {name: 'Manu', age: '29'}, {name: 'Aakash', age: '32'}]
//   });

//   const[otherState, setOtherState] = useState('Some other value');

//   const switchNameHandler = () => {
//     setPersonsState({
//       persons: [{name: 'Maxy' , age: '24'}, {name: 'Manu', age: '29'}, {name: 'Aakash', age: '32'}]
//     });
//   };

//   console.log(personStates);
//   console.log(otherState);

//     return (
//       <div className="App">
//           <h1>
//             Hi there I am a react app
//           </h1>
//           <p>This is really working!!</p>
//           <button onClick={switchNameHandler}>Switch Name</button>
//           <Person name={personStates.persons[0].name} age={personStates.persons[0].age}></Person>
//           <Person name={personStates.persons[1].name} age={personStates.persons[1].age}>My Hobbies: Racing</Person>
//           <Person name={personStates.persons[2].name} age={personStates.persons[2].age}>{otherState}</Person>
//       </div>
//     );


// }
// export default App;

class App extends Component {
  state = {
    persons: [{ name: 'Max', age: '24' }, { name: 'Manu', age: '29' }, { name: 'Aakash', age: '32' }],
    someOtherstate: "Hello Some Other state",
    showPersons: false
  };

  switchNameHandler = (newName) => {
    // console.log("Clicked");
    // this.state.persons[0].name="MaxC"; //do not do this
    this.setState({
      persons: [{ name: newName, age: '24' }, { name: 'Manu', age: '29' }, { name: 'Aakash', age: '32' }]
    });
  };

  nameChangedHandler = (event) => {
    this.setState({
      persons: [{ name: 'Max', age: '24' }, { name: event.target.value, age: '29' }, { name: 'Aakash', age: '32' }]
    })
  };

  togglePersonHandler = () => {
    const tar = !this.state.showPersons;
    this.setState({showPersons: tar})
  };

  render() {
    const bstyle = {
      backgroundColor: 'white',
      font: 'inherit',
      border: '1px solid blue',
      padding: '8px',
      cursor: 'pointer'
    };

    let persons = null;
    if(this.state.showPersons){
      persons = (
        <div >
          <Person name={this.state.persons[0].name} age={this.state.persons[0].age}></Person>
          <Person name={this.state.persons[1].name} age={this.state.persons[1].age} click={this.switchNameHandler.bind(this, 'MaximillianY')}
          changed={this.nameChangedHandler}>My Hobbies: Racing</Person>
          <Person name={this.state.persons[2].name} age={this.state.persons[2].age}>{this.state.someOtherstate}</Person>
        </div>
      );
    }

    return (
      <div className="App">
        <h1>
          Hi there I am a react app
          </h1>
        <p>This is really working!!</p>
        <button onClick={this.togglePersonHandler} style={bstyle}>Switch Name</button>
        {persons}
      </div>
    );
    // return React.createElement('div', {className: 'App'}, React.createElement('h1', null, 'Hi from create element variation'));
  }
}
export default App;
