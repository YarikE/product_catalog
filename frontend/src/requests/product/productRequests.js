import axios from "axios";

const basePath = "http://localhost:8080";

const requests = {

    /**
     * Получить список всех продуктов
     *
     * @return {Promise<axios.AxiosResponse<any> | void>}
     */
    getAllProducts: () => {
        return axios.get(basePath + "/product/all")
            .then(response => {
                return response.data;
            })
            .catch(err => {
                console.log(err)
            });
    }
}

export default requests;