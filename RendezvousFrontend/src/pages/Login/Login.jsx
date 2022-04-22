import { React, useState, useContext } from "react";
import RendezvousService from "../../repository/RendezvousRepository";
import AppContext from "../../context/app-context";
import Card from "../../components/Helper/Card/Card";
import logo from "../../assets/images/logo.png";
import Button from "../../components/Helper/Buttons/Button";
import "../Pages.css";
import "./Login.css";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [usernameVal, setUsernameVal] = useState(true);
  const [password, setPassword] = useState("");
  const [passwordVal, setPasswordVal] = useState(true);
  const [requestVal, setRequestVal] = useState(true);

  const usernameHandler = (e) => {
    let username = e.target.value;
    setUsername(username);
  };

  const passwordHandler = (e) => {
    let password = e.target.value;
    setPassword(password);
  };

  const loginHandler = (event) => {
    event.preventDefault();
    let usernameOK = false;
    let passwordOK = false;

    if (username.length > 0) {
      setUsernameVal(true);
      usernameOK = true;
    } else setUsernameVal(false);

    if (password.length > 0) {
      setPasswordVal(true);
      passwordOK = true;
    } else setPasswordVal(false);

    if (usernameOK && passwordOK) {
      RendezvousService.fetchUserByUsername(username)
        .then((response) => {
          return response.data;
        })
        .then((data) => {
          if (password === data.password) {
            appContext.dispatch({
              type: "LOGIN",
              user: {
                username: data.username,
                name: data.name,
                surname: data.surname,
                email: data.email,
                city: data.city,
              },
            });
            navigate("/profile");
            setRequestVal(true);
          } else setRequestVal(false);
        })
        .catch((error) => {
          setRequestVal(false);
        });
    }
  };

  return (
    <div className="login page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <Card>
        <form action="POST" onSubmit={loginHandler} className="login-form">
          <div
            className={`form-group ${usernameVal ? "" : "invalid"}`}
            data-error="Username cannot be empty"
          >
            <input
              id="username"
              type="text"
              className="login-input"
              placeholder="Username"
              onChange={usernameHandler}
            />
          </div>

          <div
            className={`form-group ${passwordVal ? "" : "invalid"}`}
            data-error="Invalid password"
          >
            <input
              id="password"
              type="password"
              className="login-input"
              placeholder="Password"
              onChange={passwordHandler}
            />
          </div>

          <button className="button submit-button" type="submit">
            Login{" "}
          </button>
          <p className={`login-error-message ${requestVal ? "" : "invalid"} `}>
            Invalid login attempt
          </p>
        </form>
      </Card>

      <Button text="Back to homepage" navigateTo="" />
    </div>
  );
};

export default Login;