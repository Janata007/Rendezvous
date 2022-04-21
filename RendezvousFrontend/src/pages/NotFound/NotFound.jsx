import React from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../components/Helper/Button/Button";
import Card from "../../components/Helper/Card/Card";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./NotFound.css";

const NotFound = () => {
  let navigate = useNavigate();

  return (
    <div className="not-found page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <Card>
        <h1 className="message">
          Hmmm... Looks like there isn't anything here...
        </h1>
      </Card>
      <Button text="Back to homepage" navigateTo="" />
    </div>
  );
};

export default NotFound;
