import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";

import categoryRoutes from "../../../views/Categories/routes";
import productRoutes from "../../../views/Products/routes";

import "../css/global-components.css";

function Header() {
    return (
        <Router>
            <div className="header">
                <div className="header__links">
                    <Link to={productRoutes.url} className="links__item">Продукты</Link>
                    <Link to={categoryRoutes.url} className="links__item">Категории</Link>
                </div>
                <div className="line"></div>
                <Routes>
                    <Route path={productRoutes.url} element={productRoutes.component()}></Route>
                    <Route path={categoryRoutes.url} element={categoryRoutes.component()}></Route>
                </Routes>
            </div>
        </Router>
    );
}

export default Header;