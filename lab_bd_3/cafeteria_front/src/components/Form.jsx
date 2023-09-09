import { useState } from 'react';
import { postCoffee } from '../services/ApiService';

export default function Form ({ callback }) {
    const [coffeeName, setCoffeeName] = useState();

    function handleChange(event) {
        setCoffeeName(event.target.value);
    }

    function handleSubmit(event) {
        postCoffee({ name: coffeeName });
        event.preventDefault();
        callback();
    }

    return (
        <>
            <div className="coffee-form-container">
                {postCoffee != null ? (
                    <form className="coffee-form" onSubmit={handleSubmit}>
                        <label className="form-label">
                            Name: <input className="form-input-text" type="text" name="name" onChange={handleChange} />
                        </label>
                        <input className="form-input-submit" type="submit" value="Submit" />
                    </form>
                ) : (
                    <p className="coffee-form-loading">Loading form...</p>
                )}
            </div>
        </>
    )
}
