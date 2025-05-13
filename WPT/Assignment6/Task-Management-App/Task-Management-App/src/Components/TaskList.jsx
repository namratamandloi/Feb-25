// TaskList.jsx
import { useState } from 'react';
import { ListGroup, Badge, Button } from 'react-bootstrap';
import { TaskItem } from './TaskItem';
import { FilterTasks } from './FilterTasks';
import { SearchTasks } from './SearchTasks';

export const TaskList = ({ tasks, onDelete, onUpdate }) => {
  const [filter, setFilter] = useState('all');
  const [searchTerm, setSearchTerm] = useState('');

  const filteredTasks = tasks.filter(task => {
    const matchesFilter = filter === 'all' || 
                         (filter === 'completed' && task.completed) || 
                         (filter === 'active' && !task.completed) ||
                         task.priority === filter;
    
    const matchesSearch = task.title.toLowerCase().includes(searchTerm.toLowerCase()) || 
                         task.description.toLowerCase().includes(searchTerm.toLowerCase());
    
    return matchesFilter && matchesSearch;
  });

  return (
    <div>
      <div className="d-flex justify-content-between mb-3">
        <FilterTasks filter={filter} setFilter={setFilter} />
        <SearchTasks searchTerm={searchTerm} setSearchTerm={setSearchTerm} />
      </div>
      
      {filteredTasks.length === 0 ? (
        <p>No tasks found.</p>
      ) : (
        <ListGroup>
          {filteredTasks.map(task => (
            <TaskItem 
              key={task.id} 
              task={task} 
              onDelete={onDelete} 
              onUpdate={onUpdate} 
            />
          ))}
        </ListGroup>
      )}
    </div>
  );
};