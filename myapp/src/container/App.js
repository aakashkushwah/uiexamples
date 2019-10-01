import React, { Component } from 'react';
import styles from './App.module.css';
import Persons from '../components/Persons/Persons';
import Cockpit from '../components/Cockpit/Cockpit';

class App extends Component {
  state = {
    persons: [{ id: 1, name: 'Max', age: '24' }, { id: 2, name: 'Manu', age: '29' }, { id: 3, name: 'Aakash', age: '32' }],
    someOtherstate: "Hello Some Other state",
    showPersons: false
  };

  switchNameHandler = (newName) => {
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
    if (this.state.showPersons) {
      persons = (
        <div >
          <Persons 
            persons={this.state.persons} 
            clicked={this.deletePersonHandler}
            changed={this.nameChangedHandler}>            
          </Persons>
        </div>
      );
    }
    return (
        <div className={styles.App}>
          <Cockpit
            showPersons={this.state.showPersons}
            persons={this.state.persons}
            clicked={this.togglePersonHandler}>
          </Cockpit>
          {persons}
        </div>
    );
  }
}
export default App;
