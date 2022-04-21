import { React, useState } from "react";
import Button from "../../components/Helper/Button/Button";
import Card from "../../components/Helper/Card/Card";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./Register.css";

const Register = () => {
  const [firstName, setFirstName] = useState("");

  const firstNameHandler = (e) => {
    let firstName = e.target.value;
    setFirstName(firstName);
    console.log(firstName);
  };

  const checkInputs = () => {};
  return (
    <div className="register page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <Card>
        <form action="" className="register-form">
          <div className="form-group" data-error="First name cannot be empty">
            <input
              id="firstName"
              type="text"
              className="register-input"
              placeholder="First Name"
              onChange={firstNameHandler}
            />
          </div>

          <div className="form-group" data-error="Last name cannot be empty">
            <input
              id="lastName"
              type="text"
              className="register-input"
              placeholder="Last Name"
            />
          </div>

          <div className="form-group" data-error="Not a valid email">
            <input
              id="email"
              type="text"
              className="register-input"
              placeholder="Email"
            />
          </div>

          <div
            className="form-group"
            data-error="Password must be at least 6 characters long"
          >
            <input
              id="password"
              type="password"
              className="register-input"
              placeholder="Password"
            />
          </div>
        </form>
      </Card>

      <Button text="Register" />
      <Button text="Back to homepage" navigateTo="" />
    </div>
  );
};

export default Register;
