import React, { useState } from 'react';

import productRequests from "../../../requests/product/productRequests";

import '../css/global-components.css';

const Switcher = ({ initialValue = false, productId }) => {
    const [isOn, setIsOn] = useState(initialValue);

    const toggleSwitch = () => {
        productRequests.updateProductStatus(productId, !isOn);
    };

    return (
        <div className={`switcher ${isOn ? 'switcher-on' : 'switcher-off'}`} onClick={toggleSwitch}>
            <div className={`switcher-circle ${isOn ? 'switcher-circle-on' : 'switcher-circle-off'}`}></div>
        </div>
    );
};

export default Switcher;
