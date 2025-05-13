// Home.jsx
import { useContext } from 'react';
import { TaskContext } from '../context/TaskContext';
import { TaskList } from '../Components/TaskList';

export const Home = () => {
  const { tasks, deleteTask, updateTask } = useContext(TaskContext);

  return (
    <div>
      <h1 className="mb-4">My Tasks</h1>
      <TaskList 
        tasks={tasks} 
        onDelete={deleteTask} 
        onUpdate={updateTask} 
      />
    </div>
  );
};