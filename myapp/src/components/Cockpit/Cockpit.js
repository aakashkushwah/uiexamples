import React from 'react';
import styles from './Cockpit.module.css';

const cockpit = (props) => {
    // state = {
    //     showPersons: false
    // };
    const pcls = [];
    let btnClass = '';
    if(props.showPersons === true){
        btnClass = styles.Red;
    }
    
    if(props.persons.length <= 2){
      pcls.push(styles.red);
    }
    if(props.persons.length <= 1){
      pcls.push(styles.bold);
    }

    return (
        <div className={styles.Cockpit}>
            <h1>
                Hi there I am a react app
            </h1>
            <p className={pcls.join(' ')}>This is really working!!</p>
            <button className={btnClass} onClick={props.clicked}>Toggle Persons</button>
        </div>
    );
};

export default cockpit;