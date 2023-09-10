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

export async function putCoffee(coffee) {
    return await fetch(`${API_URL}/coffees/${coffee.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name: coffee.name })
    })
    .then(response => response.json())
    .then(data => console.log('Coffee updated:', data))
    .catch(error => console.error('API -- PUT Error:', error));
}

export async function deleteCoffee(coffee) {
    return await fetch(`${API_URL}/coffees/${coffee.id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    });
}
