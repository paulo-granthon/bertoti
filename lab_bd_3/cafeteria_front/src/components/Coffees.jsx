
const Coffee = ({ coffee, onChange }) => {
    const removeCoffee = () => {
        const coffeeId = coffee.id;
        console.log('coffeeId: ', coffee);
        fetch(`http://localhost:8080/coffees/${coffeeId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(() => onChange())
        .catch((error) => {
            console.error('Error deleting coffee:', error);
        });
    };
    return (
        <div className="coffee-container">
            <p className="coffee-name">{coffee.name}</p>
            <p className="coffee-remove" onClick={removeCoffee}>X</p>
        </div>
    )
}

export default function Coffees ({ coffees, onChange }) {
    return (
        <div className="coffees-container">
            {coffees != null ? (
                <ul className="coffees-ul">
                    {coffees.map(coffee => <Coffee key={coffee.id} coffee={coffee} onChange={onChange} />)}
                </ul>
            ) : (
                <p className="coffees-ul-loading">Loading coffees...</p>
            )}
        </div>
    )
}

