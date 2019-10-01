import React, { Component } from 'react';
import styles from './App.module.css';
import Person from '../components/Persons/person/Person';

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
    persons: [{ id: 1, name: 'Max', age: '24' }, { id: 2, name: 'Manu', age: '29' }, { id: 3, name: 'Aakash', age: '32' }],
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

  nameChangedHandler = (event, id) => {
    const mypersonIndex= this.state.persons.findIndex(p => {
      return p.id === id;
    });
    const myperson = {
        ...this.state.persons[mypersonIndex]
      }; 
    //Object.assign({}, this.state.persons[mypersonIndex])
    myperson.name = event.target.value;

    const mypersons =  [...this.state.persons];
    mypersons[mypersonIndex] = myperson;

    this.setState({
      persons: mypersons
    });
  };

  togglePersonHandler = () => {
    const tar = !this.state.showPersons;
    this.setState({ showPersons: tar })
  };

  deletePersonHandler = (index) => {
    // const mypersons = this.state.persons.slice();
    const mypersons = [...this.state.persons];
    mypersons.splice(index, 1);
    this.setState({persons:mypersons});
  };

  render() {
    let persons = null;
    let btnClass = '';

    if (this.state.showPersons) {
      persons = (
        <div >
          {this.state.persons.map((per, index) => {
            return <Person
              click={()=>this.deletePersonHandler(index)}
              changed={(event) => this.nameChangedHandler(event, per.id)}
              name={per.name}
              age={per.age}
              key={per.id}>
              {per.someOtherstate}
            </Person>
          })}
        </div>
      );
      btnClass = styles.Red;
    }

    const pcls = [];
    if(this.state.persons.length <= 2){
      pcls.push('Red');
    }
    if(this.state.persons.length <= 1){
      pcls.push('bold');
    }

    return (
        <div className={styles.App}>
          <h1>
            Hi there I am a react app
            </h1>
          <p className={pcls.join(' ')}>This is really working!!</p>
          <button className={btnClass} onClick={this.togglePersonHandler}>Toggle Persons</button>
          {persons}
        </div>
    );
    // return React.createElement('div', {className: 'App'}, React.createElement('h1', null, 'Hi from create element variation'));
  }
}
export default App;
