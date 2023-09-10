import Coffee from './Coffee';

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

