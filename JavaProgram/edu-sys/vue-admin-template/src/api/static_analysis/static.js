import request from '@/utils/request'

export default  {
  countDailyRegisters(date) {
    return request({
      url: `/static-service/statistics-daily/countDailyRegisters/${date}`,
      method: 'post'
    });
  },
  getDataByType(query) {
    return request({
      url: `/static-service/statistics-daily/getDataByType`,
      method: 'post',
      data: query
    });
  }
}
