
const Coffee = ({ coffee }) => {
    return (
        <div className="coffee-container">
            <p className="coffee-name">{coffee.name}</p>
        </div>
    )
}

export default function Coffees ({ coffees }) {
    return (
        <div className="coffees-container">
            {coffees != null ? (
                <ul className="coffees-ul">
                    {coffees.map((coffee, i) => <Coffee key={i} coffee={coffee} />)}
                </ul>
            ) : (
                <p className="coffees-ul-loading">Loading coffees...</p>
            )}
        </div>
    )
}

