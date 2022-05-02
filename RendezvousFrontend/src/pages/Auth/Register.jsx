import { React, useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../components/helper/Button";
import Card from "../../components/helper/Card";
import AppContext from "../../context/app-context";
import RendezvousService from "../../repository/RendezvousRepository";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./Register.css";

const Register = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [usernameVal, setUsernameVal] = useState(true);
  const [firstName, setFirstName] = useState("");
  const [firstNameVal, setFirstNameVal] = useState(true);
  const [lastName, setLastName] = useState("");
  const [lastNameVal, setLastNameVal] = useState(true);
  const [password, setPassword] = useState("");
  const [passwordVal, setPasswordVal] = useState(true);

  const usernameHandler = (e) => {
    let username = e.target.value;
    setUsername(username);
  };

  const firstNameHandler = (e) => {
    let firstName = e.target.value;
    setFirstName(firstName);
  };

  const lastNameHandler = (e) => {
    let lastName = e.target.value;
    setLastName(lastName);
  };

  const passwordHandler = (e) => {
    let password = e.target.value;
    setPassword(password);
  };

  const registerHandler = (event) => {
    event.preventDefault();
    let usernameOK = false;
    let firstnameOK = false;
    let lastnameOK = false;
    let passwordOK = false;

    if (username.length > 0) {
      setUsernameVal(true);
      usernameOK = true;
    } else setUsernameVal(false);

    if (firstName.length > 0) {
      setFirstNameVal(true);
      firstnameOK = true;
    } else setFirstNameVal(false);

    if (lastName.length > 0) {
      setLastNameVal(true);
      lastnameOK = true;
    } else setLastNameVal(false);

    if (password.length >= 6) {
      setPasswordVal(true);
      passwordOK = true;
    } else setPasswordVal(false);

    if (usernameOK && firstnameOK && lastnameOK && passwordOK) {
      let newUser = {
        username: username,
        name: firstName,
        surname: lastName,
        password: password,
        appUserRole: "USER",
      };

      const jsonUser = JSON.stringify(newUser);
      RendezvousService.createUser(jsonUser)
        .then((response) => {
          return response.data;
        })
        .then((data) => {
          appContext.dispatch({
            type: "LOGIN",
            user: {
              id: data.id,
              username: data.username,
              name: data.name,
              surname: data.surname,
              email: data.email,
              city: data.city,
              hobbies: [],
              sports: [],
              locations: [],
              musicGenres: [],
            },
          });
          return data;
        })
        .then((data) => {
          RendezvousService.fetchAllUsers()
            .then((response) => {
              return response.data;
            })
            .then((data) => {
              appContext.dispatch({ type: "LOAD_USERS", users: data });
              navigate("/");
            })
            .catch((error) => console.log(error));
        })
        .then(() => {
          RendezvousService.fetchGeoLocation()
            .then((response) => {
              return response.data;
            })
            .then((data) => {
              appContext.dispatch({
                type: "ADD_GEOLOCATION",
                geoLocation: data,
              });
            })
            .catch((error) => console.log(error));
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  return (
    <div className="register page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <Card>
        <form
          action="POST"
          onSubmit={registerHandler}
          className="register-form"
        >
          <div
            className={`form-group ${usernameVal ? "" : "invalid"}`}
            data-error="Username cannot be empty"
          >
            <input
              id="username"
              type="text"
              className="register-input"
              placeholder="Username"
              onChange={usernameHandler}
            />
          </div>

          <div
            className={`form-group ${firstNameVal ? "" : "invalid"}`}
            data-error="First name cannot be empty"
          >
            <input
              id="firstName"
              type="text"
              className="register-input"
              placeholder="First Name"
              onChange={firstNameHandler}
            />
          </div>

          <div
            className={`form-group ${lastNameVal ? "" : "invalid"}`}
            data-error="Last name cannot be empty"
          >
            <input
              id="lastName"
              type="text"
              className="register-input"
              placeholder="Last Name"
              onChange={lastNameHandler}
            />
          </div>

          <div
            className={`form-group ${passwordVal ? "" : "invalid"}`}
            data-error="Password must be at least 6 characters long"
          >
            <input
              id="password"
              type="password"
              className="register-input"
              placeholder="Password"
              onChange={passwordHandler}
            />
          </div>

          <button className="button submit-button" type="submit">
            Register
          </button>
        </form>
      </Card>

      <Button text="Back to homepage" navigateTo="" />
    </div>
  );
};

export default Register;
