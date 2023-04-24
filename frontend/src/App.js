import './App.css';
import Navbar from './components/Navbar';
import { Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import MoviesList from './components/MoviesList';
import Genres from './components/Genres';
import MovieProfileCard from './components/MovieProfileCard';
import FavouriteMovies from './components/FavouriteMovies';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {
  return (
    <>
    <Navbar/>
    <div className='container'>
      <Routes>
        <Route path='/' element={<Home />}/>
        <Route path='/movies' element={<MoviesList />}/>
        <Route path='/genres' element={<Genres />}/>
        <Route path='/movie/:movieId' element={<MovieProfileCard />}/>
        <Route path='/favourites' element={<FavouriteMovies />}/>
      </Routes>
    </div>
    </>
  );
}

export default App;
