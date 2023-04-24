import axios from 'axios';

    const instanse = axios.create({
        baseURL: "http://localhost:8080/api/v1"
    })

export default axios;