import { React, useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import AppContext from "../../context/app-context";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./Home.css";

const Home = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  useEffect(() => {}, [appContext]);

  return (
    <div className="home page">
      <img className="logo" src={logo} alt="rendezvous-logo" />
      {appContext.isLoggedIn ? null : null}
      <button className="btn">Log In</button>
      <button
        className="btn"
        onClick={() => {
          navigate("/register");
        }}
      >
        Register
      </button>
    </div>
  );
};

export default Home;
