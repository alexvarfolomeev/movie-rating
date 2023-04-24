import React from 'react'

function Poster({movieId}) {
  return (
    <img src={"http://localhost:8080/api/v1/file/download/" + movieId} className="card-img"/>
  )
}

export default Poster