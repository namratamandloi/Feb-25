// AddTask.jsx
import { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { TaskContext } from '../context/TaskContext';
import { TaskForm } from '../Components/TaskForm';

export const AddTask = () => {
  const { addTask } = useContext(TaskContext);
  const navigate = useNavigate();

  const handleSubmit = (task) => {
    addTask(task);
    navigate('/');
  };

  return (
    <div>
      <h1 className="mb-4">Add New Task</h1>
      <TaskForm onSubmit={handleSubmit} buttonText="Add Task" />
    </div>
  );
};