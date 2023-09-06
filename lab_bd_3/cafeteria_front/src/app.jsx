import './app.css'
import { useEffect } from 'react'

import Coffees from './components/Coffees'


import {
    fetchCoffees,
} from './services/ApiService';

export function App() {
    const [coffees, setCoffees] = useState();

    useEffect(() => {
        fetchCoffees()
            .then((response) => {
                console.log(response);
                setCoffees(response);
            })
            .catch((error) => console.error('Error fetching coffees:', error));
    });

    return (
        <>
            <Coffees coffees={coffees} />
        </>
    );
}
