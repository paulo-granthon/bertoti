import axios from 'axios';

const API_URL = 'http://127.0.0.1:8080';

export async function fetchCoffees() {
    try {
        const response = await axios.get(`${API_URL}/coffees`, {});
        return response.data;
    } catch (error) {
        console.error('API -- GET Error:', error);
    }
}

export async function postCoffee(coffee) {
    try {
        return await fetch(`${API_URL}/coffees`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(coffee)
        })
        .then(response => response.json())
        .then(data => {
            console.log("Coffee added:", data);
        });
    } catch (error) {
        console.error('API -- POST Error:', error);
        return error;
        }
}

export async function postCoffee (coffee) {
    try {
        const response = await axios.post(coffee, {
            coffee
        });
    } catch (error) {
        console.error('API -- Error posting coffee ', coffee, error);
    }
}
