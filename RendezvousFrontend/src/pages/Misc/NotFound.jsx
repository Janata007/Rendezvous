import React from "react";
import Card from "../../components/helper/Card";
import Button from "../../components/helper/Button";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./Misc.css";

const NotFound = () => {
  return (
    <div className="not-found page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <Card>
        <div className="message-container">
          <h1 className="message">Looks like there isn't anything here.</h1>
        </div>
      </Card>
      <Button text="Back to homepage" navigateTo="" />
    </div>
  );
};

export default NotFound;
