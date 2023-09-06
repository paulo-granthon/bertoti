
const Coffee = ({ coffee }) => {
    return (
        <div>
            <p>{coffee.name}</p>
        </div>
    )
}

export const Coffees = ({ coffees }) => {
    return (
        <div>
            <ul>
                {coffees.map((coffee) => <Coffee name={coffee.name} />)}
            </ul>
        </div>
    )
}
