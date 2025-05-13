import { useState } from 'react';
import { Form, Button, Row, Col } from 'react-bootstrap';

export const TaskForm = ({ initialTask, onSubmit, buttonText }) => {
  const [task, setTask] = useState(initialTask || {
    title: '',
    description: '',
    priority: 'medium',
    dueDate: '',
    completed: false
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setTask({
      ...task,
      [name]: type === 'checkbox' ? checked : value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(task);
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3">
        <Form.Label>Title</Form.Label>
        <Form.Control
          type="text"
          name="title"
          value={task.title}
          onChange={handleChange}
          required
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          rows={3}
          name="description"
          value={task.description}
          onChange={handleChange}
        />
      </Form.Group>

      <Row className="mb-3">
        <Col md={6}>
          <Form.Group>
            <Form.Label>Priority</Form.Label>
            <Form.Select
              name="priority"
              value={task.priority}
              onChange={handleChange}
            >
              <option value="low">Low</option>
              <option value="medium">Medium</option>
              <option value="high">High</option>
            </Form.Select>
          </Form.Group>
        </Col>
        <Col md={6}>
          <Form.Group>
            <Form.Label>Due Date</Form.Label>
            <Form.Control
              type="date"
              name="dueDate"
              value={task.dueDate}
              onChange={handleChange}
            />
          </Form.Group>
        </Col>
      </Row>

      {buttonText === 'Update Task' && (
        <Form.Group className="mb-3">
          <Form.Check
            type="checkbox"
            label="Completed"
            name="completed"
            checked={task.completed}
            onChange={handleChange}
          />
        </Form.Group>
      )}

      <Button variant="primary" type="submit">
        {buttonText}
      </Button>
    </Form>
  );
};