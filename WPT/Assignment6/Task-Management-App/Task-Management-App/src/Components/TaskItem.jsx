// TaskItem.jsx
import { Link } from 'react-router-dom';
import { ListGroupItem, Badge, Button, Stack } from 'react-bootstrap';
import { FaEdit, FaTrash } from 'react-icons/fa';

export const TaskItem = ({ task, onDelete, onUpdate }) => {
  const getPriorityVariant = () => {
    switch (task.priority) {
      case 'high': return 'danger';
      case 'medium': return 'warning';
      case 'low': return 'success';
      default: return 'secondary';
    }
  };

  const handleToggleComplete = () => {
    onUpdate(task.id, { completed: !task.completed });
  };

  return (
    <ListGroupItem className="d-flex justify-content-between align-items-center">
      <div>
        <div className="d-flex align-items-center">
          <Form.Check
            type="checkbox"
            checked={task.completed}
            onChange={handleToggleComplete}
            className="me-2"
          />
          <Link to={`/task/${task.id}`} className={task.completed ? 'text-decoration-line-through' : ''}>
            <strong>{task.title}</strong>
          </Link>
        </div>
        <small className="text-muted">{task.description.substring(0, 50)}...</small>
      </div>
      
      <Stack direction="horizontal" gap={2}>
        <Badge bg={getPriorityVariant()} className="me-2">
          {task.priority}
        </Badge>
        {task.dueDate && (
          <Badge bg="info" className="me-2">
            Due: {new Date(task.dueDate).toLocaleDateString()}
          </Badge>
        )}
        <Button 
          as={Link} 
          to={`/edit/${task.id}`} 
          variant="outline-primary" 
          size="sm"
        >
          <FaEdit />
        </Button>
        <Button 
          variant="outline-danger" 
          size="sm" 
          onClick={() => onDelete(task.id)}
        >
          <FaTrash />
        </Button>
      </Stack>
    </ListGroupItem>
  );
};