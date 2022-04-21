import React from "react";
import Button from "../../components/Helper/Button/Button";
import logo from "../../assets/images/logo.png";
import "./Unauthenticated.css";

const Unauthenticated = () => {
  return (
    <>
      <img className="logo" src={logo} alt="rendezvous-logo" />
      <Button text="Login" navigateTo="login" />
      <Button text="Register" navigateTo="register" />
    </>
  );
};

export default Unauthenticated;
