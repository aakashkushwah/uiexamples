import React, {useEffect} from 'react';
import styles from './Cockpit.module.css';

const Cockpit = (props) => {
    useEffect(() => {
        console.log("[Cockpit.js] useEffect");
        setTimeout(() => {
            alert('save data fake');
        }, 1000);
        return () => {
            console.log("[Cockpit.js] cleanup work");
        };
    }, []);

    useEffect(()=>{
        console.log("[Cockpit.js] 2nd useEffect");
        return () => {
            console.log("[Cockpit.js] cleanup work in 2nd useEffect")
        };
    });

    const pcls = [];
    let btnClass = '';
    if(props.showPersons === true){
        btnClass = styles.Red;
    }
    
    if(props.personsLength <= 2){
      pcls.push(styles.red);
    }
    if(props.personsLength <= 1){
      pcls.push(styles.bold);
    }

    return (
        <div className={styles.Cockpit}>
            <h1>
                {props.title}
            </h1>
            <p className={pcls.join(' ')}>This is really working!!</p>
            <button className={btnClass} onClick={props.clicked}>Toggle Persons</button>
        </div>
    );
};

export default React.memo(Cockpit);