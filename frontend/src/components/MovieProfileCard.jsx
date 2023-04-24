import React from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { useEffect, useState } from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const MovieProfileCard = () => {
    const { movieId } = useParams();
    const GET_SINGLE_MOVIE_URL = "http://localhost:8080/api/v1/movie/get/" + movieId;
    const POST_MOVIE_PROFILE_IMG = "http://localhost:8080/api/v1/file/upload/" + movieId;
    const [movieData, setMovieData] = useState(Object);
    const [file, setFile] = useState([]);
    const [like, setLike] = useState(false);
    const [genres, setGenres] = useState([]);

    useEffect(() => {
        axios
            .get(GET_SINGLE_MOVIE_URL)
            .then(data => {
                setMovieData(data.data)
                setGenres(data.data.genres);
            })
    }, []);

    useEffect(() => {
        axios
            .get(`http://localhost:8080/api/v1/movie/likes/${movieId}`)
            .then(data => {
                setLike(data.data);
            })
    }, []);

    const fileSelectHendler = (e) => {
        console.log(e.target.files);
        setFile(e.target.files);
        //setFile(URL.createObjectURL(e.target.files[0]))
    }

    const fileUploadHendler = () => {
        const fd = new FormData();
        fd.append('file', file[0], file[0].name);
        console.log(fd);
        axios.post(POST_MOVIE_PROFILE_IMG, fd, { movieId: movieData.movieId }).then(resp => resp.status);
    }

    const notify = () => toast("Фильм добавлен в избранное");

    //После добавления в избранное выводить сообщение в Toaster
    const addToFavourite = (movieId, userId) => {
        axios.put(`http://localhost:8080/api/v1/movie/${movieId}/like/${userId}`, {})
            .then(resp => {
                console.log(resp);
                if (resp.status === 200) {
                    notify()
                }
            }
        );
    }

    // let genreses = movieData.genres.map(function(item) {
    //     return <td>{item.name}</td>
    //  });

    // console.log(movieData);
    // console.log(movieData.genres.map(g => g.name));
    //const genress = movieData.genres.map((g) => <li key={g.genreId}>{g.name}</li>);
    return (
        <div className="wrapper">
            <div className="poster">
                <img src={"http://localhost:8080/api/v1/file/download/" + movieData.movieId} className="card-img" />
                {/* <input id="fileUpload" type="file" onClick={fileSelectHendler}/> */}
                <button onClick={() => addToFavourite(movieData.movieId, 1)}>{like === 0 ? "Добавить в избранное" : "В избранном"}</button>
                <ToastContainer />
            </div>
            <div className="basic-data">
                <div>
                    <h1>{movieData.name}</h1>
                </div>
                <table className="table">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Год выпуска</td>
                            <td>{movieData.releaseDate}</td>
                        </tr>
                        <tr>
                            <td>Страна</td>
                            <td>{movieData.country}</td>
                        </tr>
                        <tr>
                            <td>Режисер</td>
                            <td>{movieData.director}</td>
                        </tr>
                        <tr>
                            <td>Жанр</td>
                            <td>{genres.map(g => {
                                if(genres.length - 1 === genres.indexOf(g)){
                                    return g.name; 
                                } else {
                                    return g.name + ", ";
                                }
                            })}</td>
                        </tr>
                        <tr>
                            <td>Возраст</td>
                            <td>{movieData.age}+</td>
                        </tr>
                        <tr>
                            <td>Рейтинг MPAA</td>
                            <td>{movieData.mpaa}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div className="movie-description">
                <div>
                    <hr></hr>
                </div>
                <h2>Описание</h2>
                <p>{movieData.description}</p>
            </div>
        </div>
    )
}

export default MovieProfileCard;