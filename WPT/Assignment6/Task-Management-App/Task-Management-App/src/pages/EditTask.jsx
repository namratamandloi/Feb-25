// EditTask.jsx
import { useContext, useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { TaskContext } from '../context/TaskContext';
import { TaskForm } from '../Components/TaskForm';

export const EditTask = () => {
  const { tasks, updateTask } = useContext(TaskContext);
  const { id } = useParams();
  const navigate = useNavigate();
  const [task, setTask] = useState(null);

  useEffect(() => {
    const foundTask = tasks.find(t => t.id === parseInt(id));
    if (foundTask) {
      setTask(foundTask);
    } else {
      navigate('/');
    }
  }, [id, tasks, navigate]);

  const handleSubmit = (updatedTask) => {
    updateTask(parseInt(id), updatedTask);
    navigate('/');
  };

  if (!task) return <div>Loading...</div>;

  return (
    <div>
      <h1 className="mb-4">Edit Task</h1>
      <TaskForm 
        initialTask={task} 
        onSubmit={handleSubmit} 
        buttonText="Update Task" 
      />
    </div>
  );
};