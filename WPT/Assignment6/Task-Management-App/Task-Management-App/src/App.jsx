import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { TaskProvider } from './context/TaskContext';
import { Navbar } from './Components/Navbar';
import { Home } from './pages/Home';
import { AddTask } from './pages/AddTask';
import { EditTask } from './pages/EditTask';
import { TaskDetails } from './pages/TaskDetails';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <TaskProvider>
      <Router>
        <Navbar />
        <div className="container mt-4">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/add" element={<AddTask />} />
            <Route path="/edit/:id" element={<EditTask />} />
            <Route path="/task/:id" element={<TaskDetails />} />
          </Routes>
        </div>
      </Router>
    </TaskProvider>
  );
}

export default App;