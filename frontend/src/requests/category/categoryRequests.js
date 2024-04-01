import axios from "axios";

const basePath = "http://localhost:8080";

const requests = {

    /**
     * Получить все категории
     * @return {Promise<axios.AxiosResponse<any> | void>}
     */
    getAllCategories: () => {
        return axios.get(basePath + "/category/all")
            .then(response => {
                console.log(response.data);
                return response.data;
            })
            .catch(err => {
                console.log(err);
            });
    },


};

export default requests;