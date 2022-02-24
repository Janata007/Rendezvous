import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:9000/",
  headers: {
    "Access-Control-Allow-Origin": "*",
  },
});

export default instance;
