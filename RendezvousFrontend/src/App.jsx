import { React, useContext } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Outlet,
} from "react-router-dom";
import AppProvider from "./context/AppProvider";
import Home from "./pages/Home/Home";
import Login from "./pages/auth/Login";
import Register from "./pages/auth/Register";
import NotFound from "./pages/Misc/NotFound";
import EditHobbies from "./pages/Profile/EditHobbies";
import EditLocations from "./pages/Profile/EditLocations";
import EditMusicGenres from "./pages/Profile/EditMusicGenres";
import EditSports from "./pages/Profile/EditSports";
import Profile from "./pages/Profile/Profile";
import Matches from "./pages/Profile/Matches";
import AppContext from "./context/app-context";
import Forbidden from "./pages/Misc/Forbidden";

const ProtectedRoutes = () => {
  const appContext = useContext(AppContext);

  return appContext.isLoggedIn ? <Outlet /> : <Forbidden />;
};

const App = () => {
  return (
    <AppProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />

          <Route element={<ProtectedRoutes />}>
            <Route path="/profile" element={<Profile />} />
            <Route path="/profile/editHobbies" element={<EditHobbies />} />
            <Route path="/profile/editSports" element={<EditSports />} />
            <Route
              path="/profile/editMusicGenres"
              element={<EditMusicGenres />}
            />
            <Route path="/profile/editLocations" element={<EditLocations />} />
            <Route path="/matches" element={<Matches />} />
          </Route>

          <Route path="*" element={<NotFound />} />
          <Route path="/forbidden" element={<Forbidden />} />
        </Routes>
      </Router>
    </AppProvider>
  );
};

export default App;
