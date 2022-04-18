import React from "react";
import { useNavigate } from "react-router-dom";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./NotFound.css";

const NotFound = () => {
  let navigate = useNavigate();

  return (
    <div className="not-found page">
      <img className="logo" src={logo} alt="rendezvous-logo" />
      <h1 className="message">
        Hmmm... Looks like there isn't anything here...
      </h1>
      <button
        className="btn"
        onClick={() => {
          navigate("");
        }}
      >
        Back to Homepage
      </button>
    </div>
  );
};

export default NotFound;
