// FilterTasks.jsx
import { ButtonGroup, ToggleButton } from 'react-bootstrap';

export const FilterTasks = ({ filter, setFilter }) => {
  const filters = [
    { name: 'All', value: 'all' },
    { name: 'Active', value: 'active' },
    { name: 'Completed', value: 'completed' },
    { name: 'High', value: 'high' },
    { name: 'Medium', value: 'medium' },
    { name: 'Low', value: 'low' },
  ];

  return (
    <ButtonGroup>
      {filters.map((f, idx) => (
        <ToggleButton
          key={idx}
          id={`filter-${idx}`}
          type="radio"
          variant="outline-primary"
          name="filter"
          value={f.value}
          checked={filter === f.value}
          onChange={(e) => setFilter(e.currentTarget.value)}
        >
          {f.name}
        </ToggleButton>
      ))}
    </ButtonGroup>
  );
};