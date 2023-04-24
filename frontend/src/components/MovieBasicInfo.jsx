import React from 'react'

function MovieBasicInfo({ movieData }) {
    return (
        <div>
            <div className="basic-data">
                <div>
                    <h1>{movieData.name}</h1>
                </div>
                <table className="table">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Дата релиза</td>
                            <td>{movieData.releaseDate}</td>
                        </tr>
                        <tr>
                            <td>Описание</td>
                            <td>{movieData.description}</td>
                        </tr>
                        <tr>
                            <td>Рейтинг MPAA</td>
                            <td>{movieData.mpaa}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div className="movie-description">
                <h2>Описание</h2>
                <p>{movieData.description}</p>
            </div>
        </div>
    )
}

export default MovieBasicInfo