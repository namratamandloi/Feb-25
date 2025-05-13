// SearchTasks.jsx
import { Form } from 'react-bootstrap';

export const SearchTasks = ({ searchTerm, setSearchTerm }) => {
  return (
    <Form.Group className="mb-3" style={{ width: '300px' }}>
      <Form.Control
        type="text"
        placeholder="Search tasks..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
    </Form.Group>
  );
};