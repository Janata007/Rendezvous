import React from "react";
import { useNavigate } from "react-router-dom";
import "./Button.css";

const Button = ({ text, navigateTo }) => {
  let navigate = useNavigate();

  return (
    <button className="button" onClick={() => navigate(`/${navigateTo}`)}>
      {text}
    </button>
  );
};

export default Button;
