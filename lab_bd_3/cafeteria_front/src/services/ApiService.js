import axios from 'axios';

const API_URL = 'http://127.0.0.1:8080';

export async function fetchCoffees() {
    try {
        const response = await axios.get(`${API_URL}/coffees`, {});
        return response.data;
    } catch (error) {
        console.error('API -- Error fetching coffees:', error);
    }
}
