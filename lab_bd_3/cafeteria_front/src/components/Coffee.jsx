import { useState } from 'react';
import {
    deleteCoffee,
    putCoffee,
} from '../services/ApiService';

const Coffee = ({ coffee, onChange }) => {
    const [editing, setEditing] = useState(false);
    const [coffeeName, setCoffeeName] = useState(coffee.name);

    const toggleEditing = () => {
        setEditing(true);
    }

    const removeCoffee = () => {
        console.log('removeCoffee:', coffee);
        deleteCoffee(coffee)
        .then(() => onChange())
        .catch((error) => {
            console.error('Error deleting coffee:', error);
        });
    };

    const handleChange = (event) => {
        setCoffeeName(event.target.value);
    }

    const renameCoffee = (event) => {
        event.preventDefault();
        console.log('renameCoffee:', coffee.name, '>', coffeeName);
        coffee.name = coffeeName;
        putCoffee(coffee)
        setEditing(false);
    }

    return (
        <div className="coffee-container">
            {!editing ? (
                <div className="coffee-data">
                    <p className="coffee-name" onClick={toggleEditing}>{coffeeName}</p>
                    <p className="coffee-remove" onClick={removeCoffee}>X</p>
                </div>
            ) : (
                <div className="coffee-editing">
                    <input className="coffee-editing-text" type="text" value={coffeeName} onChange={handleChange} autofocus/>
                    <button type="submit" onClick={renameCoffee}>Ok</button>
                </div>
            )}
        </div>
    )
}

export default Coffee
