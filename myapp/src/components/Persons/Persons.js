import React from 'react';
import Person from './person/Person';

const persons = props =>
    props.persons.map((per, index) => {
        return <Person
            click={() => props.clicked(index)}
            changed={(event) => props.changed(event, per.id)}
            name={per.name}
            age={per.age}
            key={per.id}>
            {per.someOtherstate}
        </Person>
    });

export default persons;