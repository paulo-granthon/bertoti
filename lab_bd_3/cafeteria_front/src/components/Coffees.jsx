
const Coffee = ({ coffee }) => {
    return (
        <div>
            <p>{coffee.name}</p>
        </div>
    )
}

export default function Coffees ({ coffees }) {
    return (
        <div>
            {coffees != null ? (
                <ul>
                    {coffees.map((coffee, i) => <Coffee key={i} coffee={coffee} />)}
                </ul>
            ) : (
                <p>Loading coffees...</p>
            )}
        </div>
    )
}

