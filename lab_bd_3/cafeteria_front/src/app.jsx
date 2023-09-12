import './app.css'
import { useState, useEffect } from 'react'

import Coffees from './components/Coffees'
import Form from './components/Form';

import {
    fetchCoffees,
} from './services/ApiService';

export function App() {
    const [coffees, setCoffees] = useState();

    const onChangeCoffeeCallback = () => {
        fetchCoffees()
        .then((response) => {
            setCoffees(response);
        })
        .catch((error) => console.error('Error fetching coffees:', error));
    }

    useEffect(() => {
        onChangeCoffeeCallback();
    }, []);

    return (
        <div className="app">
            <Form onChange={onChangeCoffeeCallback} />
            <Coffees coffees={coffees} onChange={onChangeCoffeeCallback} />
        </div>
    );
}
