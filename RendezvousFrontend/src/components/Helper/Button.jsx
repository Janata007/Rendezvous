import React from "react";
import { useNavigate } from "react-router-dom";
import "./Button.css";

const Button = ({ text, navigateTo, altColor }) => {
  let navigate = useNavigate();

  return (
    <button
      className={`button nav-button ${altColor ? "altColor" : ""}`}
      onClick={() => navigate(`/${navigateTo}`)}
    >
      {text}
    </button>
  );
};

export default Button;
