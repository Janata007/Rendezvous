import { React, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { MdLogout } from "react-icons/md";
import AppContext from "../../context/app-context";
import "./Footer.css";

const Footer = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  const logoutHandler = () => {
    appContext.dispatch({
      type: "LOGOUT",
    });
    navigate("");
  };

  return (
    <footer className="footer">
      <ul className="footer-items">
        <li className="footer-item"></li>
        <li className="footer-item"></li>
        <li className="footer-item">
          <div className="logout-container" onClick={() => logoutHandler()}>
            <MdLogout />
            <p>Sign Out</p>
          </div>
        </li>
      </ul>
    </footer>
  );
};

export default Footer;
