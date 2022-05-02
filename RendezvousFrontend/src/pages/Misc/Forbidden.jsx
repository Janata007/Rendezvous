import React from "react";
import Card from "../../components/helper/Card";
import Button from "../../components/helper/Button";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./Misc.css";

const Forbidden = () => {
  return (
    <div className="forbidden page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <Card>
        <div className="message-container">
          <h1 className="message">
            You are currently forbidden from viewing the contents of this page.
          </h1>

          <h1 className="message">
            Please sign in or create an account if you do not have one.
          </h1>
        </div>
      </Card>
      <Button text="Back to homepage" navigateTo="" />
    </div>
  );
};

export default Forbidden;
