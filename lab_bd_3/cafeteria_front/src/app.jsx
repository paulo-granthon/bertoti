import './app.css'
import { useState, useEffect } from 'react'

import Coffees from './components/Coffees'
import Form from './components/Form'


import {
    fetchCoffees,
    postCoffee,
} from './services/ApiService';
import Form from './components/Form';

export function App() {
    const [coffees, setCoffees] = useState();

    const postCoffeeCallback = () => {
        fetchCoffees()
        .then((response) => {
            setCoffees(response);
        })
        .catch((error) => console.error('Error fetching coffees:', error));
    }

    useEffect(() => {
        postCoffeeCallback();
    }, []);

    return (
        <>
            <Form callback={postCoffeeCallback}/>
            <Coffees coffees={coffees} />
        </>
    );
}
