import React, { PureComponent } from 'react';
import Person from './person/Person';

class Persons extends PureComponent {
    // static getDerivedStateFromProps(props, state) {
    //     console.log("[Persons.js] getDerivedStateFromProps");
    //     return state;
    // }

    // shouldComponentUpdate(nextProps, nextState) {
    //     const res = nextProps.persons !== this.props.persons 
    //     || nextProps.clicked !== this.props.clicked 
    //     || nextProps.changed !== this.props.changed;
    //     console.log("[Persons.js] shouldComponentUpdate", res);
    //     if (res) {
    //         return true;
    //     } else { return false; }
    // }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log("[Persons.js] getSnapshotBeforeUpdate");
        return { message: 'Snapshot!' };
    }

    componentDidUpdate(prevProps, prevStates, snapshot) {
        console.log("[Persons.js] componentDidUpdate");
        console.log(snapshot);
    }

    // componentWillReceiveProps(props){
    //     console.log("[Persons.js] componentWillReceiveProps", props);
    // }

    componentWillUnmount(){
        console.log("[Persons.js] componentsWillUnMount");
    }

    render() {
        console.log('[Persons.js] rendered');
        return this.props.persons.map((per, index) => {
            return (<Person
                click={() => this.props.clicked(index)}
                changed={(event) => this.props.changed(event, per.id)}
                name={per.name}
                age={per.age}
                key={per.id}>
                {per.someOtherstate}
            </Person>);
        });
    }
}

export default Persons;